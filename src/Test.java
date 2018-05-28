/**
 * DO NOT ADD PACKAGE TO THIS FILE
 * @author [Your-Student-ID]
 */
import java.io.*;
import java.util.*;
public class Test {
    
    public static void main(String[] args)
    {
        // The name of the file to open and define one by one value
        String fileName = "input.dat";
        String line = null;
        int readtab ;
        int read;
        int readName;
        int readchar;
        char ge;
        int tc;
        int i;
        int j;
        int solop;
        int dauphay1,dauphay2;
        ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
        ArrayList<GiangVien> listGv = new ArrayList<GiangVien>();
        ArrayList<MonHoc> listMh = new ArrayList<MonHoc>();
        ArrayList<SinhVien> Sv1Mh = new ArrayList<SinhVien>();
        ArrayList<MonHoc> Mh1Gv = new ArrayList<MonHoc>();
            // FileReader reads text files in the default encoding.
        try {
            //read file first times
            FileReader fileReader1 = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            
            while((line = bufferedReader1.readLine()) != null) 
            {
                if(line.contains("#SinhVien") == true)
                {
                    readtab=line.indexOf('n',4);
                    read=line.indexOf(',',1);
                    //sSystem.out.println(line.substring(readtab+2,read));
                    readName=line.indexOf(',',read+1);
                    //System.out.println(line.substring(read+1,readName));
                    //System.out.println(line.substring(readName+1));
                    ge = line.substring(readName+1).charAt(0);
                    listSv.add(new SinhVien(line.substring(readtab+2,read),line.substring(read+1,readName),ge));
                    
                }
                if(line.contains("#GiangVien") == true)
                {
                    readtab=line.indexOf('n',5);
                    read=line.indexOf(',',1);
                    //System.out.println(line.substring(readtab+2,read));
                    readName=line.indexOf(',',read+1);
                    //System.out.println(line.substring(read+1,readName));
                    //System.out.println(line.substring(readName+1));
                    ge = line.substring(readName+1).charAt(0);
                    listGv.add(new GiangVien(line.substring(readtab+2,read),line.substring(read+1,readName),ge));
                }
                if(line.contains("#MonHoc") == true)
                {
                    readtab=line.indexOf('c',1);
                    read=line.indexOf(',',1);
                    //System.out.println(line.substring(readtab+2,read));
                    readName=line.indexOf(',',read+1);
                    //System.out.println(line.substring(read+1,readName));
                    //System.out.println(line.substring(readName+1));
                    tc = Integer.parseInt(line.substring(readName+1));
                    listMh.add(new MonHoc(line.substring(readtab+2,read),line.substring(read+1,readName),tc));
                }
        }
        bufferedReader1.close();
            //read file second times
            FileReader fileReader2 = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            while((line = bufferedReader2.readLine()) != null) 
            {
                if(line.contains("#svTKB") == true)
                {
                    readtab=line.indexOf("B",1);
                    read=line.indexOf(',',1);
                    //System.out.println(line.substring(readtab+2,read));
                    //System.out.println(line.substring(read+1));
                    //System.out.println(listMh.size());
                    i=0;
                    while(i < listSv.size())
                    {
                        if((listSv.get(i).getId()).equals(line.substring(readtab+2,read)) == true)
                        {
                            j=0;
                            while(j < listMh.size())
                            {
                                if((listMh.get(j).getMaMH()).equals(line.substring(read+1)) == true)
                                {
                                    listSv.get(i).addMonHoc(listMh.get(j));
                                    break;
                                }
                                else
                                {
                                    j++;
                                }           
                            }
                            //System.out.println(listSv.get(i).getSvTKB());
                            i++;
                        }
                        else
                        {
                            i++;
                        }
                    }
                }
                if(line.contains("#gvTKB") == true)
                {
                    readtab=line.indexOf("B",1);
                    read=line.indexOf(',',1);
                    //System.out.println(line.substring(readtab+2,read));
                    //System.out.println(line.substring(read+1));
                    //System.out.println(listGv.get(0).getId());
                    //System.out.println((listGv.get(0).getId()).equals(line.substring(readtab+2,read)));
                    i=0;
                    while(i < listGv.size())
                    {
                        if((listGv.get(i).getId()).equals(line.substring(readtab+2,read)) == true)
                        {
                            j=0;
                            while(j < listMh.size())
                            {
                                if((listMh.get(j).getMaMH()).equals(line.substring(read+1)) == true)
                                {
                                    listGv.get(i).addMonHoc(listMh.get(j));
                                    break;
                                }
                                else
                                {
                                    j++;
                                }           
                            }
                            i++;
                        }
                        else
                        {
                            i++;
                        }
                    }
                }
            }
            bufferedReader2.close();
            i=0;
                while(i < listSv.size())
                {
                    j=0;
                    if(listSv.get(i).getSvTKB().size()>0)
                    {
                        tc=0;
                        while(j < listSv.get(i).getSvTKB().size())
                        {
                            tc = tc + listSv.get(i).getSvTKB().get(j).getTinChi();
                            j++;
                        }
                        listSv.get(i).setSoTinChiTichLuy(tc);
                        i++;
                    }
                    else
                    {
                        listSv.get(i).setSoTinChiTichLuy(0);
                        i++;
                    }
                }
            i=0;
                while(i < listGv.size())
                {
                    solop=0;
                    if(listGv.get(i).getGvTKB().size()>0)
                    {
                        solop=solop + listGv.get(i).getGvTKB().size();
                        listGv.get(i).setSoLopGiangDay(solop);
                    }
                    else
                    {
                        listGv.get(i).setSoLopGiangDay(solop);
                    }
                    i++;
                }
                //read file third times
                 FileReader fileReader3 = new FileReader(fileName);
                 // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                while((line = bufferedReader3.readLine()) != null) 
                {
                    i=0;
                    if(line.contains("#") != true )
                    {
                                        dauphay1=line.indexOf(',',1);
                                        dauphay2=line.indexOf(',',dauphay1+1);
                                        //System.out.println(line.substring(0,dauphay1));
                                        //System.out.println(line.substring(readtab+1,dauphay2));
                                        //System.out.println(line.substring(dauphay2+1));
                                        //System.out.println(listMh.size());
                                    i=0;
                                    while(i < listSv.size())
                                    {
                                        if((listSv.get(i).getId()).equals(line.substring(0,dauphay1)) == true)
                                        {
                                            listSv.get(i).getSvTKB();
                                            FileWriter fd = new FileWriter("4d.dat");
                                            j=0;
                                            while (j < listSv.get(i).getSvTKB().size())
                                            {
                                                    if(listSv.get(i).getSvTKB().size() == 1)
                                                    {
                                                            fd.write(listSv.get(i).getSvTKB().get(j).getMaMH()+','+listSv.get(i).getSvTKB().get(j).getTenMH()+','+listSv.get(i).getSvTKB().get(j).getTinChi());
                                                            j++;
                                                    }
                                                    else
                                                    {
                                                        fd.write(listSv.get(i).getSvTKB().get(j).getMaMH()+','+listSv.get(i).getSvTKB().get(j).getTenMH()+','+listSv.get(i).getSvTKB().get(j).getTinChi()+"\n");
                                                            j++;
                                                    }
                                            }
                                                                    fd.close();
                                        }
                                        i++;
                                    }
                                    i=0;
                                    while(i < listSv.size())
                                    {
                                        if(listSv.get(i).getSvTKB().size() > 0)
                                        {
                                            j=0;
                                            while(j < listSv.get(i).getSvTKB().size())
                                            {
                                                    if((listSv.get(i).getSvTKB().get(j).getMaMH()).equals(line.substring(dauphay1+1,dauphay2)) == true)
                                                    {
                                                      Sv1Mh.add(new SinhVien(listSv.get(i).getId(),listSv.get(i).getName(),listSv.get(i).getGender()));
                                                    }
                                                    j++;
                                            }
                                            i++;
                                        }
                                        else 
                                            i++;
                                    }
                                    i=0;
                                    while(i < listGv.size())
                                    {
                                        if(listGv.get(i).getGvTKB().size() > 0 && (listGv.get(i).getId().equals(line.substring(dauphay2+1))))
                                        {
                                            j=0;
                                            while(j < listGv.get(i).getGvTKB().size())
                                            {
                                                    Mh1Gv.add(new MonHoc(listGv.get(i).getGvTKB().get(j).getMaMH(),listGv.get(i).getGvTKB().get(j).getTenMH(),listGv.get(i).getGvTKB().get(j).getTinChi()));
                                                    j++;
                                            }
                                            i++;
                                        }
                                        else 
                                            i++;
                                    }
                    }
                }
                bufferedReader3.close();
                try {
                FileWriter st = new FileWriter("students.dat");
                i=0;
                while (i < listSv.size())
                {
                        st.write(listSv.get(i).getId()+','+listSv.get(i).getName()+','+listSv.get(i).getGender()+','+listSv.get(i).getSoTinChiTichLuy()+"\n");
                        i++;
                }
                                        st.close();
                FileWriter te = new FileWriter("teachers.dat");
                i=0;
                while (i < listGv.size())
                {
                        te.write(listGv.get(i).getId()+','+listGv.get(i).getName()+','+listGv.get(i).getGender()+','+listGv.get(i).getSoLopGiangDay()+"\n");
                        i++;
                }
                                        te.close();
                FileWriter fe = new FileWriter("4e.dat");
                i=0;
                while (i < Sv1Mh.size())
                {
                        fe.write(Sv1Mh.get(i).getId()+','+Sv1Mh.get(i).getName()+','+Sv1Mh.get(i).getGender()+"\n");
                        i++;
                }
                                        fe.close();
                FileWriter ff = new FileWriter("4f.dat");
                i=0;
                while (i < Mh1Gv.size())
                {
                        ff.write(Mh1Gv.get(i).getMaMH()+','+Mh1Gv.get(i).getTenMH()+','+Mh1Gv.get(i).getTinChi()+"\n");
                        i++;
                }
                                        ff.close();
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("Success....");
    }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
}

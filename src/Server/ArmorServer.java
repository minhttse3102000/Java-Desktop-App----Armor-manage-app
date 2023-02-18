/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DTO.ArmorDTO;
import GUI.Mainframe;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author minhv
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    public ArmorServer() throws RemoteException {
    }

 
    public static void main(String[] args) {
        try {         
            ArmorServer obj=new ArmorServer();
          
            LocateRegistry.createRegistry(1233);
            Runtime r=Runtime.getRuntime();
            r.exec("rmiregistry.exe");
            Naming.rebind("rmi://127.0.0.1:1233//now", obj);
            System.out.println("server dang san sang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean createArmor(ArmorDTO dto) throws RemoteException{
        PrintWriter w=null;
        List<ArmorDTO> list= findAllArmor();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            w=new PrintWriter("ArmorData.txt");           
            list.add(dto);
            for (ArmorDTO armorDTO : list) {
                w.println(armorDTO.toString()+formatter.format(armorDTO.getTimeOfCreate())+";"+armorDTO.getDefense());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(w!=null) w.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArmorDTO findByArmorID(String id) throws RemoteException{
        List<ArmorDTO> list= findAllArmor();
        int index=0;
        for (ArmorDTO armorDTO : list) {
            if(armorDTO.getArmorId().equals(id)){
                index=list.indexOf(armorDTO);
                break;
            }else{
                index=-1;
            }
        }
        if(index>=0){
            return list.get(index);
        }else{
            return null;
        }
    }

    @Override
    public List<ArmorDTO> findAllArmor() throws RemoteException{
        List<ArmorDTO> list=new ArrayList<>();
        FileReader f=null;
        BufferedReader r=null;
        try {
            Date d=new Date();
            f=new FileReader("ArmorData.txt");
            r=new BufferedReader(f);
            while(r.ready()){
                String s=r.readLine();
                String[] arr=s.split(";");
                if(arr.length==6){
                    
                    ArmorDTO armor =new ArmorDTO(arr[0], arr[1], arr[2], arr[3], d=new Date(arr[4]), Integer.parseInt(arr[5]));
                    list.add(armor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(f!=null) f.close();
                if(r!=null) r.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public boolean removeArmor(String id) throws RemoteException {
        List<ArmorDTO> list = findAllArmor();//xoa trong list truoc roi ghi lai vao file.txt
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        int index = 0;
        for (ArmorDTO armorDTO : list) {
            if (armorDTO.getArmorId().equals(id)) {
                index = list.indexOf(armorDTO);
                break;
            } else {
                index = -1;
            }
        }
        if (index >= 0) {
            list.remove(index);
            PrintWriter w = null;
            try {
                w = new PrintWriter("ArmorData.txt");
                for (ArmorDTO armorDTO : list) {
                    w.println(armorDTO.toString()+formatter.format(armorDTO.getTimeOfCreate())+";"+armorDTO.getDefense());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (w != null) {
                        w.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) throws RemoteException {
        List<ArmorDTO> list = findAllArmor();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        int index = 0;
        for (ArmorDTO armorDTO : list) {
            if (armorDTO.getArmorId().equals(dto.getArmorId())) {
                index = list.indexOf(armorDTO);
                break;
            } else {
                index = -1;
            }
        }
        if (index >= 0) {
            list.get(index).setClassification(dto.getClassification());
            list.get(index).setDescription(dto.getDescription());
            list.get(index).setStatus(dto.getStatus());
            list.get(index).setTimeOfCreate(dto.getTimeOfCreate());
            list.get(index).setDefense(dto.getDefense());
            PrintWriter w = null;
            try {
                w = new PrintWriter("ArmorData.txt");
                for (ArmorDTO armorDTO : list) {
                    w.println(armorDTO.toString() + formatter.format(armorDTO.getTimeOfCreate()) + ";" + armorDTO.getDefense());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (w != null) {
                        w.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
        
    }

    
    
}

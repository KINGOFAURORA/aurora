// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.dynamicproxy;

import java.util.concurrent.*;

class Task1 implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Task1(ConcurrentHashMap<String, String> map){
        this.map = map;
    }

    @Override
    public void run() {

        map.put("4", "4");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task1=====>>>>>" + map.get("4"));

    }
}

class Task2 implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Task2(ConcurrentHashMap<String, String> map){
        this.map = map;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task2=====>>>>>" + map.remove("4"));
    }
}

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/18 下午6:41
 **/
public class MainClass {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(6,7));
//        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(8,9));
//        list.addAll(list2);
//        list.addAll(list3);
//        System.out.println(list);
//        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer integer = iterator.next();
//            if(integer % 2 == 0){
//                iterator.remove();
//            }
//        }
//        for(Integer i : list){
//            System.out.println(i);
//        }
//        ServiceInterface object = (ServiceInterface) Proxy.newProxyInstance(ServiceInterface.class.getClassLoader(), new Class[]{ServiceInterface.class}, new ServiceInterfaceProxy(new ServiceInterfaceImpl()));
//        object.functionA();
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
//        map.put("1","1");
//        map.put("2","2");
//        map.put("3","3");
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            System.out.println(map.get(iterator.next()));
//            map.put("4", "4");
//            iterator.remove();
//        }
//        System.out.println(map);
//
//        ConcurrentHashMap<String,String> premiumPhone =
//                new ConcurrentHashMap<String,String>();
//        premiumPhone.put("Apple", "iPhone");
//        premiumPhone.put("HTC", "HTC one");
//        premiumPhone.put("Samsung","S5");
//
//        iterator = premiumPhone.keySet().iterator();
//
//        while (iterator.hasNext())
//        {
//            System.out.println(premiumPhone.get(iterator.next()));
//            premiumPhone.put("Sony", "Xperia Z");
//        }
//        System.out.println(premiumPhone);

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Task1(map));
        es.execute(new Task2(map));
    }
}

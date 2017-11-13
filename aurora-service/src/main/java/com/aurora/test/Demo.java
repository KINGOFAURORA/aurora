// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.test;

//class B implements Cloneable{
//    private int i;
//
//    public int getI() {
//        return i;
//    }
//
//    public void setI(int i) {
//        this.i = i;
//    }
//
//    public B(int i){
//        this.i = i;
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
//
//class A implements Cloneable{
////    @Override
////    protected void finalize() throws Throwable {
////        super.finalize();
////        System.out.println("finalize has been done");
////    }
//    private String s;
//
//    private B b;
//
//    public String getS() {
//        return s;
//    }
//
//    public void setS(String s) {
//        this.s = s;
//    }
//
//    public B getB() {
//        return b;
//    }
//
//    public void setB(B b) {
//        this.b = b;
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        this.b = (B) b.clone();
//        return super.clone();
//    }
//}
class AClass {

    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }
}

class Glass{

}

class Sommelier {
    Wine recommend(int meal) {
        switch (meal){
            case 1:
                return new RedWine();
            case 2:
                return new WhiteWine();
            default:
                return new Bordeaux();
        }
    }

    Glass fetchGlass(Wine wine) {
        System.out.println("wine");
        return new Glass();
    }
    Glass fetchGlass(RedWine wine) {
        System.out.println("RedWine");
        return new Glass();
    }
    Glass fetchGlass(WhiteWine wine) {
        System.out.println("WhiteWine");
        return new Glass();
    }
}

abstract class Wine {
    // 推荐酒的温度
    abstract float temperature();
}

class RedWine extends Wine {
    // 红酒的温度通常略高于白酒
    float temperature() { return 63; }
}

class WhiteWine extends Wine {
    float temperature() { return 47; }
}

class Bordeaux extends RedWine {
    float temperature() { return 64; }
}

class Riesling extends WhiteWine {
    // 继承WhiteWine类的温度
}


/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/1 上午9:59
 **/
public class Demo{

//    @Resource(name="itemAFactory")
//    private IFactory factory;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        Node<Command> node1 = new Node1();
//        Node<Command> node2 = new Node2();
//        node1.setNextNode(node2);
//        node1.execute(new N2Command());
//        ServiceClass sc = new QRServiceClass();
//        sc.setProcess(new QRRiskProcess());
//        sc.doProcess();
//
//        sc.setProcess(new QPRiskProcess());
//        sc.doProcess();
//        Component component = new Composite();
//        component.add(new Leaf());
//        System.out.println(Long.valueOf(1234).hashCode());
//        System.out.println(Long.valueOf(Integer.valueOf(1234).longValue()).hashCode());
//
//        Map<Long, Long> map = Maps.newHashMap();
//        map.put(Long.valueOf(1234), 1234L);
//        System.out.println(map.get(Integer.valueOf(1234)));
//        StateContext context = new StateContext(new StateA());
//        context.request();
//        context.request();
//        context.request();
//        ClassA a = new ClassA.Builder().build();
//        SubjectB subjectB = new SubjectB();
//        subjectB.addObserver(new ObserverB());
//        subjectB.setMessage();
//        ISubject subject = new SubjectA();
//        subject.addObserver(new ObserverA(subject));
//        subject.notifyObserver();

//        Director director = new Director(new ABuilder());
//        Product product = director.construct();
//        Director director2 = new Director(new BBuilder());
//        Product product2 = director2.construct();

//        BaseTemplate baseTemplate = new ExtTemplateA();
//        baseTemplate.templateMethod();
//        baseTemplate = new ExtTemplateB();
//        baseTemplate.templateMethod();

//        IFactory factory = new ItemAFactory();
//
//        Item item = factory.createItem();
//
//        item.print();

//        A a = new A();
//        a.setS("aa");
//        B b = new B(2);
//        a.setB(b);
//
//        A a1 = (A) a.clone();
//        a1.setS("bb");
//
//        b.setI(3);
//
//        System.out.println(a.getS());
//        System.out.println(a1.getB().getI());

//        ServiceInterface proxy = (ServiceInterface) Proxy.newProxyInstance(ServiceInterface.class.getClassLoader(), new Class[] {ServiceInterface.class}, new ServiceInterfaceProxy(new ServiceInterfaceImpl()));
//        System.out.println("proxy:" + proxy.getClass());
//        proxy.functionA();
//        IService service = new ServiceImpl();
//
//        IServiceDecorator serviceDecorator1 = new DecoratorA();
//        IServiceDecorator serviceDecorator2 = new DecoratorB();
//
//        serviceDecorator1.setService(service);
//        serviceDecorator2.setService(serviceDecorator1);
//
//        serviceDecorator2.functionA();

//        Item item = DemoFactory.getItem(2);
//        item.print();
//        StrategyContext context = new StrategyContext(new ItemA());
//        context.print();
//        context = new StrategyContext(new ItemB());
//        context.print();

//        Exception e = new Exception("aaa");
//        RuntimeException re = new RuntimeException(e);
//        System.out.println(re.getCause().getMessage());
//        functionA(1, 2);
//        for(;;){
//            A a = new A();
//        }
    }
}

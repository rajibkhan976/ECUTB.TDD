
public class main {

    public static void main(String[] args) {
 
        Class1 c1 = new Class1();
        Class2 c2 = new Class2(c1);
        
        c2.compute();
        
/*        
        IntArray arr = new IntArray();
        IntArrayObserver obs = new IntArrayObserver( arr);
        
        arr.Attach(obs);

        arr.deleteAt(23);
 */       
        
/*        
        Timer timer = new Timer();
        AnalogDisplay ad = new AnalogDisplay(timer);
        DigitalDisplay dd = new DigitalDisplay(timer);

        timer.tick();
        timer.Detach(ad);
        timer.tick();
*/
        /*
         * FileStream f = new FileStream(); f.copy();
         * 
         * System.out.println("------------------------------------");
         * 
         * INetStream i = new INetStream(); i.copy();
         */
    }

}

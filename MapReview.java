import java.util.HashMap;
import java.util.Map;

public class MapReview {
    public static void main(String[] args) {
        Map<String, Integer> fee = new HashMap<>();

        fee.put("bus", 500);
        fee.put("subway", 1500);
        fee.put("bike", 800);
        fee.put("express bus", 25000);
        fee.put("rail", 10000);
        fee.put("airplane", 50000);

        System.out.println(fee.size());
        
        System.out.println(fee.get("bus"));
        fee.put("bus",700);
        System.out.println(fee.get("bus"));

        System.out.println(fee.containsKey("buses"));

        for (String key : fee.keySet()) {
            System.out.println(key + ":" + fee.get(key));
        }       

        
    }
    
}

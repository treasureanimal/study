package sheji.Strategy.eg2;

import java.util.HashMap;
import java.util.Map;

public class Context {

    //缓存所有策略，当前是无状态的，可以共享策略类对象
    private static final Map<String,GearStrategy> strate = new HashMap<>();

    //第一种写法
    static {
        strate.put("one",new GearStrategyOne());
        strate.put("two",new GearStrategyTwo());
    }

    public static GearStrategy getGearStrategy(String type){
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strate.get(type);
    }

    //第二种写法
    public static GearStrategy getStrategySecond(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("one")) {
            return new GearStrategyOne();
        }else if (type.equals("two")) {
            return new GearStrategyTwo();
        }
        return null;
    }

    public static void main(String[] args) {
        // 测试结果
        GearStrategy strategyOne = Context.getGearStrategy("one");
        strategyOne.algotithm("1档");
        // 结果：当前档位1档
        GearStrategy strategyTwo = Context.getStrategySecond("two");
        strategyTwo.algotithm("2档");
        // 结果：当前档位1档
    }
}

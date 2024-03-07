package org.example.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/6 7:16
 **/
public class S0118_generate {

    @Test
    public void test() {
        S0118_generate exe = new S0118_generate();
        List<List<Integer>> result = exe.generate(5);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list = new ArrayList();
        list.add(1);
        result.add(list);
        if (numRows == 1) {
            return result;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            for (int j = 0; j < list.size(); j++) {
                if (j + 1 < list.size()) {
                    tempList.add(list.get(j) + list.get(j + 1));
                } else {
                    tempList.add(list.get(j));
                }
            }
            list = tempList;
            result.add(tempList);
        }

        return result;
    }
}

package org.example.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/9 10:04
 **/
public class S0119_GetRow {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            for (int j = 0; j < res.size() - 1; j++) {
                list.add(res.get(j) + res.get(j + 1));
            }

            list.add(1);

            res = list;
        }

        return res;
    }
}

package com.yulecha.utils.test.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @ClassName：OverrideEquals
 * @Description：
 * @Author：MaRui
 * @Date：2020/11/5 10:38
 * @Version 1.0
 **/
@Data
public class OverrideEquals {

    private BigDecimal size34;

    private BigDecimal size36;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OverrideEquals) {
            OverrideEquals node = (OverrideEquals) obj;
            return (Objects.equals(size34, node.size34) && Objects.equals(size36, node.size36));
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size34, size36);
    }
}

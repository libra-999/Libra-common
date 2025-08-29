package main.java.org.project.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import com.ruoyi.common.utils.poi.ExcelHandlerAdapter;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel
{

    int sort() default Integer.MAX_VALUE;

    String name() default "";

    String dateFormat() default "";

    String dictType() default "";

    String readConverterExp() default "";

    String separator() default ",";

    int scale() default -1;

    @SuppressWarnings("deprecation") int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    double height() default 14;

    double width() default 16;

    String suffix() default "";

    String defaultValue() default "";

    String prompt() default "";

    boolean wrapText() default false;

    String[] combo() default {};

    boolean comboReadDict() default false;

    boolean needMerge() default false;

    boolean isExport() default true;

    String targetAttr() default "";

    boolean isStatistics() default false;

    ColumnType cellType() default ColumnType.STRING;

    IndexedColors headerBackgroundColor() default IndexedColors.GREY_50_PERCENT;

    IndexedColors headerColor() default IndexedColors.WHITE;

    IndexedColors backgroundColor() default IndexedColors.WHITE;

    IndexedColors color() default IndexedColors.BLACK;

    HorizontalAlignment align() default HorizontalAlignment.CENTER;

    Class<?> handler() default ExcelHandlerAdapter.class;

    String[] args() default {};

    Type type() default Type.ALL;

    enum Type
    {
        ALL(0), EXPORT(1), IMPORT(2);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    enum ColumnType
    {
        NUMERIC(0), STRING(1), IMAGE(2), TEXT(3);
        private final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
}
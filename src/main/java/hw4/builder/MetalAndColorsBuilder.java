package hw4.builder;

import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import lombok.Builder;
import java.util.List;

@Builder
public class MetalAndColorsBuilder {
    private List<String> summary;
    private List<Elements> elements;
    private List<Colors> colors;
    private List<Metals> metals;
    private List<Vegetables> vegetables;
}

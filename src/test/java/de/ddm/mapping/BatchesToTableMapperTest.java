package de.ddm.mapping;

import de.ddm.structures.Table;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author timo.buechert
 */
public class BatchesToTableMapperTest {

    @Test
    public void convertToTables() {
        //given
        final String[][] headerLines = new String[][]{{"a", "b", "c"}, {"d", "e", "f"}};
        final Map<Integer, List<List<String[]>>> batches = Map.of(
                0, List.of(List.of(new String[]{"a1", "b1", "c1"}, new String[]{"a2", "b2", "c2"})),
                1, List.of(List.of(new String[]{"d1", "e1", "f1"}, new String[]{"d2", "e2", "f2"}))
        );

        //when
        final List<Table> tables = BatchesToTableMapper.convertToTables(headerLines, batches);

        //then
        assertThat(tables).hasSize(2);
        assertThat(tables.get(0).getId()).isEqualTo(0);
        assertThat(tables.get(0).getHeader().get(0)).isEqualTo("a");
        assertThat(tables.get(0).getHeader().get(1)).isEqualTo("b");
        assertThat(tables.get(0).getHeader().get(2)).isEqualTo("c");
        assertThat(tables.get(0).getData()).isEqualTo(List.of(List.of("a1", "a2"), List.of("b1", "b2"), List.of("c1", "c2")));

        assertThat(tables.get(1).getId()).isEqualTo(1);
        assertThat(tables.get(1).getHeader().get(0)).isEqualTo("d");
        assertThat(tables.get(1).getHeader().get(1)).isEqualTo("e");
        assertThat(tables.get(1).getHeader().get(2)).isEqualTo("f");
        assertThat(tables.get(1).getData()).isEqualTo(List.of(List.of("d1", "d2"), List.of("e1", "e2"), List.of("f1", "f2")));
    }
}
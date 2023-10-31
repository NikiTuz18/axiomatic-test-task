package ru.nikituz.axiomatictesttask.dto.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerSearch {

    private String searchQuery;

    private SearchType searchType;

    @RequiredArgsConstructor
    public enum SearchType {
        FIO("FIO"), PASSPORT("PASSPORT"), PHONE("PHONE");

        private final String name;

        @Override
        public String toString() {
            return this.name;
        }
    }
}

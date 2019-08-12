package com.tech_613.podcast.utils;

import android.content.SearchRecentSuggestionsProvider;

public class QuerySuggestionProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY ="com.tech_613.podcast.utils.QuerySuggestionProvider";
    public static final int MODE=DATABASE_MODE_QUERIES;

    public QuerySuggestionProvider(){
        setupSuggestions(AUTHORITY,MODE);
    }
}

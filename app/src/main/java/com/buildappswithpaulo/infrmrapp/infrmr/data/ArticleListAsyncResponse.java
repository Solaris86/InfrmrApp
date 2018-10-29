package com.buildappswithpaulo.infrmrapp.infrmr.data;

import java.util.ArrayList;

public interface ArticleListAsyncResponse {
    void processFinish(ArrayList<Article> articles);
}

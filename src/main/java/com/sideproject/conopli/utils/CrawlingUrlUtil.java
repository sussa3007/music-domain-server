package com.sideproject.conopli.utils;

import com.sideproject.conopli.music.dto.PopularRequestDto;
import com.sideproject.conopli.music.dto.SearchRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CrawlingUrlUtil {

//    @Value("${CRAWLING_URL}")
    private static final String crawlingUrl = "http://tjmedia.com/tjsong/";

    public static String createSearchUrl(SearchRequestDto dto) {
        // 1 = 제목, 2 가수 , 4 작사가 , 8 작곡가, 16 곡번호
        int searchType = dto.getSearchType();
        int searchPage = dto.getSearchPage();
        String searchKeyWord = dto.getSearchKeyWord();
        // KOR, ENG, JPN
        String searchNation = dto.getSearchNation();
        StringBuilder sb = new StringBuilder();
        sb.append(crawlingUrl);
        sb.append("song_search_list.asp");
        sb.append("?strType=");
        sb.append(searchType);
        sb.append("&natType=");
        sb.append(searchNation);
        sb.append("&strText=");
        sb.append(searchKeyWord);
        sb.append("&strCond=0");
        sb.append("&searchOrderType=&searchOrderItem=&intPage=");
        sb.append(searchPage);
        return sb.toString();
    }

    public static String createPopularUrl(PopularRequestDto dto) {
        String searchType = dto.getSearchType();
        String syy = dto.getSyy();
        String smm = dto.getSmm();
        String eyy = dto.getEyy();
        String emm = dto.getEmm();

        StringBuilder sb = new StringBuilder();
        sb.append(crawlingUrl);
        sb.append("song_monthPopular.asp");
        sb.append("?strType=");
        sb.append(searchType);
        sb.append("&SYY=");
        sb.append(syy);
        sb.append("&SMM=");
        sb.append(smm);
        sb.append("&EYY=");
        sb.append(eyy);
        sb.append("&EMM=");
        sb.append(emm);
        return sb.toString();
    }
    public static String createNewSongUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(crawlingUrl);
        sb.append("song_monthNew.asp");
        return sb.toString();
    }

    public static String createAutoSearchUrl(String searchKeyWord, String searchNation) {
        int searchType = 16;
        int searchPage = 1;
        // KOR, ENG, JPN
        StringBuilder sb = new StringBuilder();
        sb.append(crawlingUrl);
        sb.append("song_search_list.asp");
        sb.append("?strType=");
        sb.append(searchType);
        sb.append("&natType=");
        sb.append(searchNation);
        sb.append("&strText=");
        sb.append(searchKeyWord);
        sb.append("&strCond=1");
        sb.append("&searchOrderType=&searchOrderItem=&intPage=");
        sb.append(searchPage);
        sb.append("&strWord=1");
        return sb.toString();
    }
}

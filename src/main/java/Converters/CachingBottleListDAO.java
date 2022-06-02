package Converters;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import POJOs.BottleList;

import java.util.List;

public class CachingBottleListDAO {

    private final LoadingCache<String, BottleList> cache;

    public CachingBottleListDAO(BottleListDAO bListDA0) {
        cache = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, BottleList>());// object call method from listDAO
    }

    public List<BottleList> getAllListsForUserCellar(String listId) {
        return cache.getUnchecked(listId); // use this ID as this is how it was mapped
    }
}

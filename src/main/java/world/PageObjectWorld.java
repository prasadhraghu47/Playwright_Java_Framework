package world;

import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PageObjectWorld {

    private final Map<Class<?>, Object> pageObjectMap = new ConcurrentHashMap<>();
    private final Page page; // Playwright page

    public PageObjectWorld(Page page) {
        this.page = page;
    }

    public <T> T getPageObject(Class<T> pageClass) {
        return (T) pageObjectMap.computeIfAbsent(pageClass, clazz -> {
            try {
                return clazz.getDeclaredConstructor(Page.class).newInstance(page);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create page object: " + clazz.getName(), e);
            }
        });
    }

}

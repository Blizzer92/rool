package de.blizzer.rool;

public interface AnalyticsEngine {
	void initialize();
    void setEnabled(boolean enabled);
    void trackPageView(String path);
    void setCustomVar(int slot, String label, String val, int scope);
    void trackEvent(String category, String subCategory, String label, int value);
    void dispatch();
}

package com.veronica;

class ObservableSB {

    private StringBuilder delegateBuilder;
    private OnStringCL onChangeListener;

    ObservableSB() {
        delegateBuilder = new StringBuilder();
    }

    ObservableSB(String string) {
        delegateBuilder = new StringBuilder(string);
    }

    void setOnChangeListener(OnStringCL onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    ObservableSB append(Object obj) {
        delegateBuilder.append(obj);
        notifyListeners();
        return this;
    }

    public ObservableSB insert(int index, char[] str, int offset, int len) {
        delegateBuilder.insert(index, str, offset, len);
        notifyListeners();
        return this;
    }

    public ObservableSB replace(int start, int end, String str) {
        delegateBuilder.replace(start, end, str);
        notifyListeners();
        return this;
    }

    public ObservableSB delete(int start, int day) {
        delegateBuilder.delete(start, day);
        notifyListeners();
        return this;
    }

    private void notifyListeners() {
        if (onChangeListener != null)
            onChangeListener.onStringChanged(this);
    }

    @Override
    public String toString() {
        return delegateBuilder.toString();
    }
}
package com.youwin.spaceshooter.components;

import com.artemis.Component;

public class NameComponent extends Component {
    private String name;

    public NameComponent() {
        name = "Unnamed";
    }

    public NameComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
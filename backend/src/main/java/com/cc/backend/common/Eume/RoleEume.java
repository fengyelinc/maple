package com.cc.backend.common.Eume;

public enum RoleEume {
    ADMINISTRATOR(1l),
    VIP(2l),
    USER(3l);

    private Long id;

    RoleEume(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

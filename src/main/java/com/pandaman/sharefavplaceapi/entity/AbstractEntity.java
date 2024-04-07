package com.pandaman.sharefavplaceapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/**
 * DB共通Entity
 */

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {
    /** 登録日時 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    /** 更新日時 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    /** 更新日時の設定 */
    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(new Date());
    }
}

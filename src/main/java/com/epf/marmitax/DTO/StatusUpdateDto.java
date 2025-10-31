package com.epf.marmitax.DTO;

import com.epf.marmitax.models.ApprovalStatus;

public class StatusUpdateDto {
    private ApprovalStatus status;

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }
}

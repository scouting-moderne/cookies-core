package io.moderne.scouting.cookies.error;

import jakarta.annotation.Nullable;

public record ApiError(String title,
                       String detail,
                       @Nullable Integer status) {
}

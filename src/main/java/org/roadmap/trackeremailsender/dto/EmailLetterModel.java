package org.roadmap.trackeremailsender.dto;

public record EmailLetterModel(
        String email,
        String title,
        String description
) {}

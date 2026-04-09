package org.roadmap.trackeremailsender.models;

public record EmailLetterModel(
        String email,
        String title,
        String description
) {}

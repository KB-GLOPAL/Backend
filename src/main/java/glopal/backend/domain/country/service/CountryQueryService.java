package glopal.backend.domain.country.service;

import glopal.backend.domain.country.dto.response.CountryResponse;

public interface CountryQueryService {
    CountryResponse.CountryInfo getCountry(Long userId);
}

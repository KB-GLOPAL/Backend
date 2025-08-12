package glopal.backend.domain.country.service;

import glopal.backend.domain.country.dto.request.CountryRequest;
import glopal.backend.domain.country.dto.response.CountryResponse;

public interface CountryCommandService {
    CountryResponse.CountryInfo createCountry(CountryRequest.CreateCountry createCountry);
}

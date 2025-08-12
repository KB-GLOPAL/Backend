package glopal.backend.domain.country.service;

import glopal.backend.domain.country.dto.request.CountryRequest;
import glopal.backend.domain.country.dto.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryCommandServiceImpl implements CountryCommandService {

    @Override
    public CountryResponse.CountryInfo createCountry(CountryRequest.CreateCountry createCountry) {
        return null;
    }
}

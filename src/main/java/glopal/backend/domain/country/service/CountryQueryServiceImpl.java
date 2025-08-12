package glopal.backend.domain.country.service;

import glopal.backend.domain.country.dto.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CountryQueryServiceImpl implements CountryQueryService {

    @Override
    public CountryResponse.CountryInfo getCountry(Long userId) {
        return null;
    }
}

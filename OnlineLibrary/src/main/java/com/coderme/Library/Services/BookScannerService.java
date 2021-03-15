package com.coderme.Library.Services;

import com.coderme.Library.Converters.UrlToBookConverter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.stereotype.Service;


@Service
@Data
@Slf4j
public class BookScannerService {
    private final BookFilter bookFilter;
    private final UrlToBookConverter transformer;
    private final FileReadingMessageSource fileReadingMessageSource;


    @Bean
    public IntegrationFlow getIntegrationFlow(){
       return IntegrationFlows.from(fileReadingMessageSource, sourcePollingChannelAdapterSpec -> sourcePollingChannelAdapterSpec.poller(Pollers.fixedDelay(500)))
               .filter(bookFilter)
               .transform(transformer).get();

    }


}

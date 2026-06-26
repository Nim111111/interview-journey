package com.nim.interviewjourney.service;

import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.exception.ResourceNotFoundException;
import com.nim.interviewjourney.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @Test
    void shouldReturnApplicationWhenIdExists() {

        ApplicationEntity application = new ApplicationEntity();
        application.setId(1L);
        application.setCompanyName("Amazon");

        when(applicationRepository.findById(1L))
                .thenReturn(Optional.of(application));

        ApplicationEntity result =
                applicationService.getById(1L);

        assertNotNull(result);
        assertEquals("Amazon", result.getCompanyName());

        verify(applicationRepository, times(1))
                .findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExist() {

        when(applicationRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> applicationService.getById(999L)
        );

        verify(applicationRepository, times(1))
                .findById(999L);
    }
}
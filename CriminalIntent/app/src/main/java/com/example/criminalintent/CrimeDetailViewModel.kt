package com.example.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class CrimeDetailViewModel: ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        Transformations.switchMap(crimeIdLiveData) {
            crimeId -> crimeRepository.getCrime(crimeId)
        }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }
}
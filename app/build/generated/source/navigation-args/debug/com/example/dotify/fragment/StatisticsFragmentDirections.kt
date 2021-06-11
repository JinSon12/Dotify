package com.example.dotify.fragment

import androidx.navigation.NavDirections
import com.example.dotify.NavGraphDirections
import com.example.dotify.model.Song

public class StatisticsFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalStatisticsFragment(song: Song): NavDirections =
        NavGraphDirections.actionGlobalStatisticsFragment(song)
  }
}

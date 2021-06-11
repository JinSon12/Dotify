package com.example.dotify.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.dotify.NavGraphDirections
import com.example.dotify.R
import com.example.dotify.model.Song

public class SettingsFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingsFragmentToAboutFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_aboutFragment)

    public fun actionSettingsFragmentToProfileFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_profileFragment)

    public fun actionGlobalStatisticsFragment(song: Song): NavDirections =
        NavGraphDirections.actionGlobalStatisticsFragment(song)
  }
}

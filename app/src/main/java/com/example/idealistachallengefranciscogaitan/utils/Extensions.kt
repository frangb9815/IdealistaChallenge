package com.example.idealistachallengefranciscogaitan.utils

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.buildInflater(): LayoutInflater =
    LayoutInflater.from(this.context)
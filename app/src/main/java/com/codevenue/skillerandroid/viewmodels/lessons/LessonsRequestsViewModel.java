package com.codevenue.skillerandroid.viewmodels.lessons;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codevenue.skillerandroid.datamanagers.LessonsDataManager;
import com.codevenue.skillerandroid.datamanagers.lessons.LessonsRequestsDataManager;
import com.codevenue.skillerandroid.model.misc.Lesson;

import java.util.List;

public class LessonsRequestsViewModel extends ViewModel {

    private MediatorLiveData<List<Lesson>> lessonMediatorLiveData;
    private LessonsRequestsDataManager lessonsDataManager;


    public LessonsRequestsViewModel(){
        Log.d("CREATIONmmmm", "CREATED");

        this.lessonMediatorLiveData = new MediatorLiveData<>();
        this.lessonsDataManager = new LessonsRequestsDataManager();
    }


    public MediatorLiveData<List<Lesson>> getLessons(String childLessonsUpcoming) {
        if(lessonMediatorLiveData.getValue() == null){
            lessonMediatorLiveData.addSource(lessonsDataManager.getLessons(childLessonsUpcoming), new Observer<List<Lesson>>() {
                @Override
                public void onChanged(@Nullable List<Lesson> lessons) {
                    lessonMediatorLiveData.setValue(lessons);
                }
            });
        }
        return lessonMediatorLiveData;
    }

}

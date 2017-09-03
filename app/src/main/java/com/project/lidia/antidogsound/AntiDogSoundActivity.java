package com.project.lidia.antidogsound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;
import android.widget.Toast;

public class AntiDogSoundActivity extends AppCompatActivity {

    SeekBar volumeControl;
    SeekBar frequencyControl;

    ToneGenerator toneGen;
    int typeTone = ToneGenerator.TONE_DTMF_0;
    int vol = 20;

    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anti_dog_sound);

        //sound code

        toneGen = new ToneGenerator(AudioManager.STREAM_DTMF, vol);

        volumeControl = (SeekBar) findViewById(R.id.volum);
        frequencyControl = (SeekBar) findViewById(R.id.frecventa);

//        Sets the current progress to the specified value.
        volumeControl.setProgress(vol);

//        A callback that notifies clients when the progress level has been changed.
        volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;

//            Notification that the progress level has changed.
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                progressChanged = progress;
            }

//            Notification that the user has started a touch gesture.
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Log.d("MyApp", "on start tracking");
            }

//            Notification that the user has finished a touch gesture.
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("MyApp", "on stop tracking " + progressChanged);
                Toast.makeText(AntiDogSoundActivity.this, "Volume progress is: " + progressChanged,
                        Toast.LENGTH_SHORT).show();
                vol = progressChanged;
                // change the volume
                if (started) {
                    toneGen.stopTone();
                    toneGen = new ToneGenerator(AudioManager.STREAM_DTMF,
                            progressChanged);
                    toneGen.startTone(typeTone);
                } else {
                    toneGen = new ToneGenerator(AudioManager.STREAM_DTMF,
                            progressChanged);
                }
            }
        });

        frequencyControl.setProgress(1);
        frequencyControl
                .setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                    int progressChanged = 0;

                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        progressChanged = progress;
                        // Log.d("MyApp", "on progress changed");
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Log.d("MyApp", "on start tracking");
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.d("MyApp", "on stop tracking " + progressChanged);
                        Toast.makeText(AntiDogSoundActivity.this, "Frequency progress is: " + progressChanged,
                                Toast.LENGTH_SHORT).show();

                        // change the frequency
                        if (progressChanged >= 0 && progressChanged < 10) {
                            typeTone = ToneGenerator.TONE_DTMF_0;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_0);
                            }
                        }
                        if (progressChanged >= 10 && progressChanged < 20) {
                            typeTone = ToneGenerator.TONE_DTMF_1;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_1);
                            }
                        }
                        if (progressChanged >= 20 && progressChanged < 30) {
                            typeTone = ToneGenerator.TONE_DTMF_2;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_2);
                            }
                        }

                        if (progressChanged >= 30 && progressChanged < 40) {
                            typeTone = ToneGenerator.TONE_DTMF_3;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_3);
                            }
                        }

                        if (progressChanged >= 40 && progressChanged < 50) {
                            typeTone = ToneGenerator.TONE_DTMF_4;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_4);
                            }
                        }

                        if (progressChanged >= 50 && progressChanged < 60) {
                            typeTone = ToneGenerator.TONE_DTMF_5;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_5);
                            }
                        }
                        if (progressChanged >= 60 && progressChanged < 70) {
                            typeTone = ToneGenerator.TONE_DTMF_6;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_6);
                            }
                        }
                        if (progressChanged >= 70 && progressChanged < 80) {
                            typeTone = ToneGenerator.TONE_DTMF_7;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_7);
                            }
                        }
                        if (progressChanged >= 80 && progressChanged < 90) {
                            typeTone = ToneGenerator.TONE_DTMF_8;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_8);
                            }
                        }
                        if (progressChanged >= 90 && progressChanged < 100) {
                            typeTone = ToneGenerator.TONE_DTMF_9;
                            if (started) {
                                toneGen.stopTone();
                                toneGen.startTone(ToneGenerator.TONE_DTMF_9);
                            }
                        }

                    }
                });
    }

    public void actionStartStop(View view) {
        // start or stop player
        if (!started) {
            // start
            toneGen.startTone(typeTone);
            started = true;
        } else {
            // stop
            toneGen.stopTone();
            started = false;
        }
    }

}

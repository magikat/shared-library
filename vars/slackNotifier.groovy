#!/usr/bin/env groovy

def call(String buildResult) {

  if ( buildResult == "Success" ) {
    color = "good"
  }
  else if( buildResult == "Failure" ) { 
    color = "danger"
  }
  else if( buildResult == "Unstable" ) { 
    color = "warning"
  }
  else {
    color = "danger"
  }

// Send notifications
  slackSend color: "${color}", message: "${env.JOB_NAME} on ${branch} branch - ${buildResult} after ${currentBuild.durationString} (<${env.RUN_DISPLAY_URL}|Open>) (<${env.RUN_CHANGES_DISPLAY_URL}|  Changes>)"

}

#!/usr/bin/env groovy

def call(String buildResult) {

  if ( buildResult == "SUCCESS" ) {
    color = "good"
  }
  else if( buildResult == "FAILURE" ) { 
    color = "danger"
  }
  else if( buildResult == "UNSTABLE" ) { 
    color = "warning"
  }
  else {
    color = "danger"
  }

// Send notifications
slackSend color: "${color}", message: "${env.JOB_NAME} on ${branch} branch - ${env.BUILD_RESULT} after ${currentBuild.durationString} (<${env.RUN_DISPLAY_URL}|Open>) (<${env.RUN_CHANGES_DISPLAY_URL}|  Changes>)"

}

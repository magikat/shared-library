#!/usr/bin/env groovy

def call(String buildResult) {
  
  String projectBranch = evaluate("projectBranch")
  
  if ( buildResult == "SUCCESS" ) {
    color = "good"
    status = "Success"
  }
  else if( buildResult == "FAILURE" ) {
    color = "danger"
    status = "Failure"
  }
  else if( buildResult == "UNSTABLE" ) {
    color = "warning"
    status = "Unstable"
  }
  else {
    color = "danger"
    status = "Unknown"
  }
  
  if ( projectBranch == null ) {
    projectBranch = "${env.BRANCH_NAME}"
  }

// Send notifications
  slackSend color: "${color}", message: "${env.JOB_NAME} on ${projectBranch} branch - ${status} after ${currentBuild.durationString} (<${env.RUN_DISPLAY_URL}|Open>) (<${env.RUN_CHANGES_DISPLAY_URL}|  Changes>)"

}

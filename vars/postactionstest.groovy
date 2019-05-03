def call() {

    archiveArtifacts artifacts: 'artifactsdir/*', onlyIfSuccessful: true
    slackNotifier(currentBuild.currentResult)
    
}

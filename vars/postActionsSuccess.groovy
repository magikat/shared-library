def call() {

    String version = evaluate("version")
    boolean image_only = evaluate("image_only")
    
    if ( image_only == null ) {
        image_only = false
    }

    build job: 'docker_image', propagate: false, wait: false, parameters: [[$class: 'StringParameterValue', name: 'project', value: "${env.JOB_NAME}"],[$class: 'StringParameterValue', name: 'version', value: "${version}"],[$class: 'StringParameterValue', name: 'projectBranch', value: "${env.projectBranch}"]]
    script {
        if ("${env.projectBranch}" == 'master' && image_only == false) {
            archiveArtifacts artifacts: 'dist/**/*', onlyIfSuccessful: true
            build job: 'upload_release_to_s3', propagate: false, wait: false, parameters: [[$class: 'StringParameterValue', name: 'projectArtifacts', value: "${env.JOB_NAME}"]]
        }
    }

}

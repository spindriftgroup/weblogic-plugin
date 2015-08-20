/**
 * Copyright 2015 Spindrift
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.weblogic

import groovy.lang.Closure;

import org.gradle.util.ConfigureUtil

class WeblogicPluginExtension {
  
  /** The plugin extension name **/
  String name
  def name(String name) {
    name = name
  }
  
  /** The weblogic home environment variable **/
  String homeEnvVar='WL_HOME'
  def homeEnvVar(String homeEnvVar) {
    this.homeEnvVar = homeEnvVar
  }
  String home = (!(homeEnvVar?.isEmpty())) ? System.getenv(homeEnvVar) : 'undefined'

  /** The middleware home environment variabla **/
  String middlewareHomeEnvVar='MW_HOME'
  def middlewareHomeEnvVar(String middlewareHomeEnvVar) {
    this.middlewareHomeEnvVar = middlewareHomeEnvVar
  }
  String mwHome=System.getenv(middlewareHomeEnvVar)
  
  /** The directory for user projects **/
  String userProjectsDir="${mwHome}/user_projects"
  def userProjectsDir(String userProjectsDir) {
    this.userProjectsDir = userProjectsDir
  }
  
  /** The directory to find applications for deployment **/
  String applicationsDir="${userProjectsDir}/applications"
  def applicationsDir(String applicationsDir) {
    this.applicationsDir = applicationsDir
  }

  /** The domains directory **/
  String domainsDir="${userProjectsDir}/domains"
  def domainsDir(String domainsDir) {
    this.domainsDir = domainsDir
  }
  
  /** The deployment directory **/
  String deployDir=applicationsDir
  def deployDir(String deployDir) {
    this.deployDir = deployDir
  }
  
  /** The common bin directory for WLST **/
  String commonBinDir="${home}/common/bin"
  def commonBinDir(String commonBinDir) {
    this.commonBinDir = commonBinDir
  }
  
  
}

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
package com.spindrift.gradle.plugins

/**
 * Provides OracleWebLogic domain management and configuration
 *
 * @author hallatech
 */

import java.text.MessageFormat

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

import com.spindrift.gradle.weblogic.tasks.CleanDomain

class WeblogicPlugin implements Plugin<Project> {
  
static final String PLUGIN_EXTENSION_NAME="weblogic"
static final String TASK_GROUP_NAME="WebLogic"
static final String CLEAN_DOMAIN_TASK="cleanDomain"
static final String SHOW_DEFAULT_DOMAIN_TASK="showDefaultDomain"
static final String SHOW_ENVIRONMENT_TASK="showEnvironment"

  @Override
  public void apply(Project project) {
    project.extensions."${PLUGIN_EXTENSION_NAME}" = new WeblogicPluginExtension()
    addCleanDomainTask(project)
    addShowEnvironmentTask(project)
    addShowDefaultDomainTask(project)
  }
  
  private void addCleanDomainTask(Project project) {
    project.task(CLEAN_DOMAIN_TASK, type: CleanDomain )
  }
  
  private void addShowEnvironmentTask(Project project) {
    Task task = project.getTasks().create(SHOW_ENVIRONMENT_TASK)
    task.description="Show the current configured WebLogic environment"
    task.group=TASK_GROUP_NAME
    task.doLast {
      project.logger.lifecycle "WebLogic Environment Details"
      project.logger.lifecycle "----------------------------"
      project.logger.lifecycle "${project.getAt(PLUGIN_EXTENSION_NAME).homeEnvVar}=${project.getAt(PLUGIN_EXTENSION_NAME).home}"
      project.logger.lifecycle "${project.getAt(PLUGIN_EXTENSION_NAME).middlewareHomeEnvVar}=${project.getAt(PLUGIN_EXTENSION_NAME).mwHome}"
      project.logger.lifecycle "Domains directory: ${project.getAt(PLUGIN_EXTENSION_NAME).domainsDir}"
      project.logger.lifecycle "User projects directory: ${project.getAt(PLUGIN_EXTENSION_NAME).userProjectsDir}"
      project.logger.lifecycle "Applications directory: ${project.getAt(PLUGIN_EXTENSION_NAME).applicationsDir}"
      project.logger.lifecycle "Common bin directory: ${project.getAt(PLUGIN_EXTENSION_NAME).commonBinDir}"
      project.logger.lifecycle "Configured Domains: ${project.getAt(PLUGIN_EXTENSION_NAME).domains.collect{it.name}.join(',')}"
      project.logger.lifecycle "Default: ${project.getAt(PLUGIN_EXTENSION_NAME).findDefaultDomain()}"
    }
  }
  
  private void addShowDefaultDomainTask(Project project) {
    Task task = project.getTasks().create(SHOW_DEFAULT_DOMAIN_TASK)
    task.description="Show the default domain details"
    task.group=TASK_GROUP_NAME
    task.doLast {
      project.logger.lifecycle "${project.getAt(PLUGIN_EXTENSION_NAME).findDefaultDomain()}"
    }
  }
  
}

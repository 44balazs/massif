#!/bin/sh -l

vncserver :1 -geometry 1280x800 -depth 24
vnc_pid=$!
export DISPLAY=:1

mvn clean install -B -f ${GITHUB_WORKSPACE}/releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=.repository
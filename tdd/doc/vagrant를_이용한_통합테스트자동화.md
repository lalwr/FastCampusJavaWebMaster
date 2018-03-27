## 테스트 환경 구성

1. 하이퍼바이저 설치 (VirtualBox, VMWare 등)
2. Vagrant 설치
    - Vagrant는 설정 스크립트를 기반으로 특정 환경의 가상 머신을 만들어 신속하게 개발 환경을 구축공유할 수 있게 해줌

## 표준 테스트 환경 구성 : Vagrant Custom Box 이미지 생성 및 사용

base box 생성
- vagrant box add { public-box-name }
- vagrant init { public-box-name }

base box를 통해 생성한 VM에 테스트 환경에서 필요한 소프트웨어 설치
- vagrant up
- vagrant ssh

ex> mysql, tomcat 등 설치

구성된 표준 테스트 환경을 custom box 이미지로 만들기
- vagrant package --output {custom-box-name}

custom박스를 network에 올림

Vagrant에서 custom box 이미지 사용

Vagrantfile

config.vm.box =  "http://10.0.0.0/boxes/{custom-box-name}"

## Vagrant provisioning을 통해 데이터베이스 스키마 생성 및 기본 데이터 적재

Vagrant provisioning
소프트웨어를 설치하고 필요한 구성을 셋팅해서 실행할 수 있도록 해 놓는 것
provisioner: Shell, Chef Solo, Chef, Puppet, Docker ...
database에 데이터를 import하거나 하는등의 일도 수행하도록 함

Vagrantfile
config.vm.provision :shell, path: "util/provision.sh"

## maven에서 통합 테스트 수행 전/후 자동으로 Vagrant 구동/종료시키기

net.ju-n.maven.plugins:vagrant-maven-plugin : direct access to Vagrant commands
cf.) http://nicoulaj.github.io/vagrant-maven-plugin/
supported maven goals
vagrant:box-add
vagrant:init
vagrant:package
vagrant:ssh
vagrant:provision
vagrant:up
...

## maven에서 통합 테스트 수행 전/후 자동으로 Vagrant 구동/종료시키기

maven exec-maven-plugin : execute system and Java programs
maven pre-integration-test phase: vagrant up 수행
maven post-integration-test phase: vagrant destroy --force 수행


##Maven pom.xml

```
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <executions>
    <execution>
      <id>start-vagrant-vm</id>
      <phase>pre-integration-test</phase>
      <goals>
        <goal>exec</goal>
      </goals>
      <configuration>
        <executable>vagrant</executable>
        <arguments>
          <argument>up</argument>
        </arguments>
      </configuration>
    </execution>
    <execution>
      <id>destroy-vagrant-vm</id>
      <phase>post-integration-test</phase>
      <goals>
        <goal>exec</goal>
      </goals>
      <configuration>
        <executable>vagrant</executable>
        <arguments>
          <argument>destroy</argument>
          <argument>--force</argument>
        </arguments>
      </configuration>
    </execution>
  </executions>
</plugin>

```


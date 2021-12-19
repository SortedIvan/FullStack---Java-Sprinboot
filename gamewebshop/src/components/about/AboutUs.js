import React from 'react'

import PropTypes from 'prop-types'
import projectStyles from './style.module.css'
import styles from './hero.module.css'
import { useHistory } from "react-router";

const AboutUs = (props) => {

  const History = useHistory();

  function onGetStartedClick(){
    History.push("/games");
  }

  return (
    <div className={styles['Hero']} id = "container">
      <img
        alt={props.image_alt}
        src={props.image_src}
        className={styles['image']}
      />
      <div className={styles['container']}>
        <h1 className={styles['text']}>{props.heading}</h1>
        <h2 className={styles['text1']}>{props.heading1}</h2>
        <div className={styles['BtnGroup']}>
          <button onClick = {onGetStartedClick} id = "gamesbutton"
            className={` ${styles['button']} ${projectStyles['button']} `}
          >
            {props.button}
          </button >
        </div>
        <span className={styles['text2']}>
          <span>
            At Playvera, we aim to create a community where developers can
            create and share indie games, upload different assets and help each
            other with the path of creating a game.
          </span>
          <br></br>
          <span></span>
        </span>
      </div>
    </div>
  )
}

AboutUs.defaultProps = {
  heading1: 'Find indie titles or create your own',
  button: 'Get Started',
  image_src:
    '/image.jpg',
  heading: 'A place for indie game developers',
  image_alt: 'image',
}

AboutUs.propTypes = {
  heading1: PropTypes.string,
  button: PropTypes.string,
  image_src: PropTypes.string,
  heading: PropTypes.string,
  image_alt: PropTypes.string,
}

export default AboutUs;
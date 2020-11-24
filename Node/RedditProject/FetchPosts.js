var snoowrap = require('snoowrap');

// snoowrap is a package that interfaces nodejs with Reddit's API



/**
* snoowrap constructor(userAgent(description), clientID, clientSecret,refreshToken, accessToken)

clientId and clientSecret were generated on reddit's development site for this specific app,
refreshToken and accessToken were generated through oauth
I used an async function because I wanted to use the aysnc await relationship.

The clientID and clientSecret are generated on Reddit's developer portal.
The refreshToken and accessToken are generated on a third party oauth2 protocol.
*/

module.exports =  async function topPosts(){
  const i = new snoowrap({userAgent: 'I yank the top posts every hour from r/whatisthisthing, r/unpopularopinion, and r/aww',
            clientId: 'xDEt155Z5gUISw',
            clientSecret: 'CULtVA4xAltqkzZ-1Yst-mwarNE',
            refreshToken: '296945469-tSrMZ3G0zwJPGsNPOR97kV2soas',
            accessToken: '296945469-1KuYuKBMpW1G7w1Li0t47bdfhBc'})


  const what = await i.getSubreddit('whatisthisthing');
  const opinion = await i.getSubreddit('unpopularopinion');
  const aww = await i.getSubreddit('aww');

  const whatPosts = await what.getTop({time: 'hour', limit: 3});
  const opinionPosts = await opinion.getTop({time: 'hour', limit: 3});
  const awwPosts = await aww.getTop({time: 'hour', limit: 3});

  let posts = whatPosts.concat(opinionPosts, awwPosts);
  let info = [];

  posts.forEach((post) => {
    info.push({
      link: post.url,
      text: post.title,
      //score is upvotes - downvotes
      score: post.score
    })
  });

  console.log(info);
};

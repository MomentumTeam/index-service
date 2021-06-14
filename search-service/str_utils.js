function cleanString(str) {
  cleanStr = str.replace(/[$&+,:;=?@#|'<>.^*()%!{}-]/g, " ");
  cleanStr = cleanStr.replace(/[^A-Za-z0-9\u0590-\u05FF\u0600-\u06FF]/g, " "); // Without special characters
  cleanStr = cleanStr.replace(/\r?\n|\r/g, " ");
  cleanStr = cleanStr.trim().replace(/\s+/g, " ");
  return cleanStr;
}

function getStringWithBold(str, query) {
  if (!query || !str) {
    return str;
  }
  const queryArray = query.split(" ");

  str = str.replace(new RegExp("<b>", "g"), "");
  str = str.replace(new RegExp("</b>", "g"), "");

  resultstr = str;
  queryArray.forEach((element) => {
    const matches = str.match(new RegExp(element, "ig"));

    if (matches) {
      matches.forEach((matchString) => {
        resultstr = resultstr.replace(new RegExp(matchString, "g"), `<b>${matchString}</b>`);
      });
    }
  });
  return resultstr;
}

module.exports = { getStringWithBold, cleanString };

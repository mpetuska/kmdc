config.module.rules.push(
    {
      test: /\.(jpe?g|png|gif|svg)$/i,
      type: 'asset/resource',
      generator: {
        filename: "images/[hash][ext][query]",
      }
    },
    {
      test: /\.(woff|woff2|eot|ttf|otf)$/,
      type: 'asset/resource',
      generator: {
        filename: "webfonts/[hash][ext][query]",
      }
    }
);
